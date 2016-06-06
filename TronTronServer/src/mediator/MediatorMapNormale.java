/*
 * Copyright (C) 2016 durza9390
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mediator;

import ActorManager.ActorManager;
import Models.world.Direction;

/**
 * @author durza9390
 */
public class MediatorMapNormale extends MediatorMap {

    private MediatorLobby lobby;

    public MediatorMapNormale(String mapName, int maxX, int maxY, MediatorLobby lobby) {
        super(mapName, maxX, maxY);
        this.lobby = lobby;
    }
    // Envoyer au client qu'il est mort

    @Override
    public void verifyMove(ActorManager a) {
        for (ActorManager b : super.getListActorManager()) {
            if (a != b && checkCollision(a.getlethalHitbox(), b.getKillingHitbox())) {
                if (a != b) {
                    super.ChangeActorMap(a, lobby);
                    b.getActor().setSpeed(b.getActor().getSpeed() + 2);
                }
            }
        }
    }
}