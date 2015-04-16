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
package quests.Q299_GatherIngredientsForPie;

import net.sf.l2j.gameserver.model.actor.L2Npc;
import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
import net.sf.l2j.gameserver.model.quest.Quest;
import net.sf.l2j.gameserver.model.quest.QuestState;

public class Q299_GatherIngredientsForPie extends Quest
{
	private static final String qn = "Q299_GatherIngredientsForPie";
	
	// NPCs
	private static final int LARA = 30063;
	private static final int BRIGHT = 30466;
	private static final int EMILY = 30620;
	
	// Items
	private static final int FRUIT_BASKET = 7136;
	private static final int AVELLAN_SPICE = 7137;
	private static final int HONEY_POUCH = 7138;
	
	public Q299_GatherIngredientsForPie()
	{
		super(299, qn, "Gather Ingredients for Pie");
		
		questItemIds = new int[]
		{
			FRUIT_BASKET,
			AVELLAN_SPICE,
			HONEY_POUCH
		};
		
		addStartNpc(EMILY);
		addTalkId(EMILY, LARA, BRIGHT);
		
		addKillId(20934, 20935); // Wasp Worker, Wasp Leader
	}
	
	@Override
	public String onAdvEvent(String event, L2Npc npc, L2PcInstance player)
	{
		String htmltext = event;
		QuestState st = player.getQuestState(qn);
		if (st == null)
			return htmltext;
		
		if (event.equalsIgnoreCase("30620-1.htm"))
		{
			st.setState(STATE_STARTED);
			st.set("cond", "1");
			st.playSound(QuestState.SOUND_ACCEPT);
		}
		else if (event.equalsIgnoreCase("30620-3.htm"))
		{
			st.set("cond", "3");
			st.playSound(QuestState.SOUND_MIDDLE);
			st.takeItems(HONEY_POUCH, -1);
		}
		else if (event.equalsIgnoreCase("30063-1.htm"))
		{
			st.set("cond", "4");
			st.playSound(QuestState.SOUND_MIDDLE);
			st.giveItems(AVELLAN_SPICE, 1);
		}
		else if (event.equalsIgnoreCase("30620-5.htm"))
		{
			st.set("cond", "5");
			st.playSound(QuestState.SOUND_MIDDLE);
			st.takeItems(AVELLAN_SPICE, 1);
		}
		else if (event.equalsIgnoreCase("30466-1.htm"))
		{
			st.set("cond", "6");
			st.playSound(QuestState.SOUND_MIDDLE);
			st.giveItems(FRUIT_BASKET, 1);
		}
		else if (event.equalsIgnoreCase("30620-7a.htm"))
		{
			if (st.hasQuestItems(FRUIT_BASKET))
			{
				htmltext = "30620-7.htm";
				st.takeItems(FRUIT_BASKET, 1);
				st.rewardItems(57, 25000);
				st.playSound(QuestState.SOUND_FINISH);
				st.exitQuest(true);
			}
			else
				st.set("cond", "5");
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
				htmltext = (player.getLevel() < 34) ? "30620-0a.htm" : "30620-0.htm";
				break;
			
			case STATE_STARTED:
				int cond = st.getInt("cond");
				switch (npc.getNpcId())
				{
					case EMILY:
						if (cond == 1)
							htmltext = "30620-1a.htm";
						else if (cond == 2)
						{
							if (st.getQuestItemsCount(HONEY_POUCH) >= 100)
								htmltext = "30620-2.htm";
							else
							{
								htmltext = "30620-2a.htm";
								st.exitQuest(true);
							}
						}
						else if (cond == 3)
							htmltext = "30620-3a.htm";
						else if (cond == 4)
						{
							if (st.hasQuestItems(AVELLAN_SPICE))
								htmltext = "30620-4.htm";
							else
							{
								htmltext = "30620-4a.htm";
								st.exitQuest(true);
							}
						}
						else if (cond == 5)
							htmltext = "30620-5a.htm";
						else if (cond == 6)
							htmltext = "30620-6.htm";
						break;
					
					case LARA:
						if (cond == 3)
							htmltext = "30063-0.htm";
						else if (cond > 3)
							htmltext = "30063-1a.htm";
						break;
					
					case BRIGHT:
						if (cond == 5)
							htmltext = "30466-0.htm";
						else if (cond > 5)
							htmltext = "30466-1a.htm";
						break;
				}
				break;
		}
		
		return htmltext;
	}
	
	@Override
	public String onKill(L2Npc npc, L2PcInstance player, boolean isPet)
	{
		L2PcInstance partyMember = getRandomPartyMember(player, npc, "1");
		if (partyMember == null)
			return null;
		
		QuestState st = partyMember.getQuestState(qn);
		
		if (st.dropItems(HONEY_POUCH, 1, 100, 500000))
			st.set("cond", "2");
		
		return null;
	}
	
	public static void main(String[] args)
	{
		new Q299_GatherIngredientsForPie();
	}
}