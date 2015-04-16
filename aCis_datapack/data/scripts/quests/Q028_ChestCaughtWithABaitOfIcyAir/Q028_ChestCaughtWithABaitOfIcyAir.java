/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package quests.Q028_ChestCaughtWithABaitOfIcyAir;

import net.sf.l2j.gameserver.model.actor.L2Npc;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.model.quest.Quest;
import net.sf.l2j.gameserver.model.quest.QuestState;

public class Q028_ChestCaughtWithABaitOfIcyAir extends Quest
{
	private static final String qn = "Q028_ChestCaughtWithABaitOfIcyAir";
	
	// NPCs
	private static final int OFulle = 31572;
	private static final int Kiki = 31442;
	
	// Items
	private static final int BigYellowTreasureChest = 6503;
	private static final int KikisLetter = 7626;
	private static final int ElvenRing = 881;
	
	public Q028_ChestCaughtWithABaitOfIcyAir(int questId, String name, String descr)
	{
		super(questId, name, descr);
		
		questItemIds = new int[]
		{
			KikisLetter
		};
		
		addStartNpc(OFulle);
		addTalkId(OFulle, Kiki);
	}
	
	@Override
	public String onAdvEvent(String event, L2Npc npc, L2PcInstance player)
	{
		String htmltext = event;
		QuestState st = player.getQuestState(qn);
		if (st == null)
			return htmltext;
		
		if (event.equalsIgnoreCase("31572-04.htm"))
		{
			st.set("cond", "1");
			st.setState(STATE_STARTED);
			st.playSound(QuestState.SOUND_ACCEPT);
		}
		else if (event.equalsIgnoreCase("31572-07.htm"))
		{
			if (st.hasQuestItems(BigYellowTreasureChest))
			{
				st.set("cond", "2");
				st.takeItems(BigYellowTreasureChest, 1);
				st.giveItems(KikisLetter, 1);
			}
			else
				htmltext = "31572-08.htm";
		}
		else if (event.equalsIgnoreCase("31442-02.htm"))
		{
			if (st.hasQuestItems(KikisLetter))
			{
				htmltext = "31442-02.htm";
				st.takeItems(KikisLetter, 1);
				st.giveItems(ElvenRing, 1);
				st.playSound(QuestState.SOUND_FINISH);
				st.exitQuest(false);
			}
			else
				htmltext = "31442-03.htm";
		}
		
		return htmltext;
	}
	
	@Override
	public String onTalk(L2Npc npc, L2PcInstance player)
	{
		QuestState st = player.getQuestState(qn);
		String htmltext = getNoQuestMsg();
		if (st == null)
			return htmltext;
		
		switch (st.getState())
		{
			case STATE_CREATED:
				if (player.getLevel() < 36)
					htmltext = "31572-02.htm";
				else
				{
					QuestState st2 = player.getQuestState("Q051_OFullesSpecialBait");
					if (st2 != null && st2.isCompleted())
						htmltext = "31572-01.htm";
					else
						htmltext = "31572-03.htm";
				}
				break;
			
			case STATE_STARTED:
				int cond = st.getInt("cond");
				switch (npc.getNpcId())
				{
					case OFulle:
						if (cond == 1)
							htmltext = (!st.hasQuestItems(BigYellowTreasureChest)) ? "31572-06.htm" : "31572-05.htm";
						else if (cond == 2)
							htmltext = "31572-09.htm";
						break;
					
					case Kiki:
						if (cond == 2)
							htmltext = "31442-01.htm";
						break;
				}
				break;
			
			case STATE_COMPLETED:
				htmltext = getAlreadyCompletedMsg();
				break;
		}
		
		return htmltext;
	}
	
	public static void main(String[] args)
	{
		new Q028_ChestCaughtWithABaitOfIcyAir(28, qn, "Chest caught with a bait of icy air");
	}
}