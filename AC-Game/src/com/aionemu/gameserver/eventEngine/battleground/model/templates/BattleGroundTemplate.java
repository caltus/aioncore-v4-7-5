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
package com.aionemu.gameserver.eventEngine.battleground.model.templates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maestross
 */
@XmlRootElement(name = "battleground")
@XmlAccessorType(XmlAccessType.FIELD)
public class BattleGroundTemplate {

    @XmlAttribute(name = "tpl_id", required = true)
    private int tplId;
    @XmlAttribute(name = "world_id", required = true)
    private int worldId;
    @XmlAttribute(name = "type", required = true)
    private BattleGroundType type;
    @XmlAttribute(name = "name", required = true)
    private String name;
    @XmlAttribute(name = "target_score", required = true)
    private int targetScore;
    @XmlAttribute(name = "price", required = true)
    private int price;
    @XmlAttribute(name = "nb_players", required = true)
    private int nbPlayers;
    @XmlAttribute(name = "wait_time", required = true)
    private int waitTime;
    @XmlAttribute(name = "bg_time", required = true)
    private int bgTime;
    @XmlElement(name = "join_conditions", required = true)
    private BattleGroundJoinConditions joinConditions;
    @XmlElement(name = "insert_point", required = true)
    private ObjectLocation insertPoint;
    @XmlElement(name = "healer_location", required = true)
    private ObjectLocation healerLocation;
    @XmlElement(name = "flag_location", required = true)
    private ObjectLocation flagLocation;
    @XmlElement(name = "rules", required = true)
    private BattleGroundRules rules;

    public int getTplId() {
        return tplId;
    }

    public int getWorldId() {
        return worldId;
    }

    public String getName() {
        return name;
    }

    public int getTargetScore() {
        return targetScore;
    }

    public int getPrice() {
        return price;
    }

    public int getNbPlayers() {
        return nbPlayers;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public int getBgTime() {
        return bgTime;
    }

    public BattleGroundJoinConditions getJoinConditions() {
        return joinConditions;
    }

    public ObjectLocation getInsertPoint() {
        return insertPoint;
    }

    public ObjectLocation getHealerLocation() {
        return healerLocation;
    }

    public BattleGroundRules getRules() {
        return rules;
    }

    public BattleGroundType getType() {
        return type;
    }

    public ObjectLocation getFlagLocation() {
        return flagLocation;
    }
}
