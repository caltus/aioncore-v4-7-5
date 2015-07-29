/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, ragarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 */
package quest.beshmundir;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;
import com.aionemu.gameserver.services.QuestService;

/**
 * @author vlog
 */
public class _30249NewHarp extends QuestHandler {

    private final static int questId = 30249;

    public _30249NewHarp() {
        super(questId);
    }

    @Override
    public void register() {
        int[] debilkarims = {286904, 281419, 215795};
        qe.registerQuestNpc(799032).addOnQuestStart(questId);
        qe.registerQuestNpc(799032).addOnTalkEvent(questId);
        qe.registerGetingItem(182213287, questId);
        for (int debilkarim : debilkarims) {
            qe.registerQuestNpc(debilkarim).addOnKillEvent(questId);
        }
    }

    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        DialogAction dialog = env.getDialog();
        int targetId = env.getTargetId();

        if (qs == null || qs.getStatus() == QuestStatus.NONE) {
            if (targetId == 799032) { // Gefeios
                if (player.getInventory().getItemCountByItemId(102000685) >= 1) { // Noble Siel's Supreme Harp
                    if (dialog == DialogAction.QUEST_SELECT) {
                        return sendQuestDialog(env, 4762);
                    } else {
                        return sendQuestStartDialog(env);
                    }
                }
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 799032) { // Gefeios
                if (dialog == DialogAction.USE_OBJECT) {
                    if (player.getInventory().getItemCountByItemId(182213287) > 0) {
                        return sendQuestDialog(env, 10002);
                    }
                } else {
                    removeQuestItem(env, 182213287, 1);
                    return sendQuestEndDialog(env);
                }
            }
        }
        return false;
    }

    @Override
    public boolean onKillEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        int targetId = env.getTargetId();
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            switch (targetId) {
                case 286904:
                case 281419:
                case 215795: {
                    if (QuestService.collectItemCheck(env, true)) {
                        return giveQuestItem(env, 182213287, 1);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean onGetItemEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        if (qs != null && qs.getStatus() == QuestStatus.START) {
            changeQuestStep(env, 0, 0, true); // reward
            return true;
        }
        return false;
    }
}
