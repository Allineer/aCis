/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.l2j.gameserver.skills.funcs;

import net.sf.l2j.gameserver.skills.Env;
import net.sf.l2j.gameserver.skills.Stats;
import net.sf.l2j.gameserver.skills.basefuncs.Func;

public class FuncMaxHpAdd extends Func
{
	static final FuncMaxHpAdd _fmha_instance = new FuncMaxHpAdd();
	
	public static Func getInstance()
	{
		return _fmha_instance;
	}
	
	private FuncMaxHpAdd()
	{
		super(Stats.MAX_HP, 0x10, null, null);
	}
	
	@Override
	public void calc(Env env)
	{
		env.addValue(env.getPlayer().getTemplate().getBaseHp(env.getPlayer().getLevel()));
	}
}