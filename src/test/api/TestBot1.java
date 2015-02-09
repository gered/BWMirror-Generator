package test.api;

import bwapi4.*;
import bwapi4.Text.Size.*;
import bwapi4.Text.Size.Enum;

/**
 * User: PC
 * Date: 18. 6. 2014
 * Time: 14:55
 */

public class TestBot1 {

    public void run() {
        final Mirror mirror = new Mirror();
        mirror.getModule().setEventListener(new DefaultBWListener() {
            @Override
            public void onUnitCreate(Unit unit) {
                System.out.println("New unit " + unit.getType());
            }

            @Override
            public void onStart() {
                System.out.println("-------Analysing map-------");
                //BWTA.readMap();
                //BWTA.analyze();
                System.out.println();

                mirror.getGame().enableFlag(bwapi4.Flag.Enum.UserInput.getValue());
            }

            @Override
            public void onFrame() {
                Game game = mirror.getGame();
                Player self = game.self();

                game.drawBoxScreen(0, 0, 100,100,Color.Red,true);

                game.setTextSize(Enum.Small);
                game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace());

                StringBuilder units = new StringBuilder("My units:\n");
                 /*
                for(Player player : game.getPlayers()){
                    System.out.println(player.getName());
                    for(Unit enemyUnit: player.()){
                        System.out.println(enemyUnit.getType());
                    }
                }


                for (Unit myUnit : self.getUnits()) {
                    units.append(myUnit.getType()).append(" ").append(myUnit.getTilePosition()).append("\n");

                    if (myUnit.getType() == UnitType.Zerg_Larva && self.minerals() >= 50) {
                        myUnit.morph(UnitType.Zerg_Drone);
                    }

                    if (myUnit.getType().isWorker() && myUnit.isIdle()) {
                        Unit closestMineral = null;

                        for (Unit neutralUnit : game.neutral().getUnits()) {
                            if (neutralUnit.getType().isMineralField()) {
                                if (closestMineral == null || myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
                                    closestMineral = neutralUnit;
                                }
                            }
                        }


                        if (closestMineral != null) {
                            myUnit.gather(closestMineral, false);
                        }
                    }
                }
                                   */


                //draw my units on screen
                game.drawTextScreen(10, 25, Utils.formatText("hello world", Utils.Blue));
            }
        });
        /*
        mirror.setFrameCallback(new Mirror.FrameCallback() {
            @Override
            public void update() {


            }
        });
          */
        mirror.startGame();
    }

    public static void main(String... args) {
        new TestBot1().run();
    }
}
