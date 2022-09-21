public class Mediator {
    public static void main(String[] args) {
        Commander commander= new CommanderImpl();
        ArmedUnit soldierUnit=new SoldierUnit(commander);
        ArmedUnit tankUnit=new TankUnit(commander);
        commander.registerArmedUnits(soldierUnit, tankUnit);
        commander.startAttack(soldierUnit);
        commander.startAttack(tankUnit);
        commander.ceaseAttack(soldierUnit);
        commander.startAttack(tankUnit);
    }
}

interface Commander{
    public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    public void setAttackStatus(boolean attackStatus);
    public boolean canAttack();
    public void startAttack(ArmedUnit armedUnit);
    public void ceaseAttack(ArmedUnit armedUnit);
}


class CommanderImpl implements Commander {
    ArmedUnit soldierUnit, tankUnit;
    boolean attackStatus = true;
    @Override
    public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit) {
        this.soldierUnit = soldierUnit;
        this.tankUnit = tankUnit;
    }
    @Override
    public void setAttackStatus(boolean attackStatus) {
        this.attackStatus = attackStatus;
    }
    @Override
    public boolean canAttack() {
        return attackStatus;
    }
    @Override
    public void startAttack(ArmedUnit armedUnit) {
        armedUnit.attack();
    }
    @Override
    public void ceaseAttack(ArmedUnit armedUnit) {
        armedUnit.stopAttack();
    }
}

interface ArmedUnit {
    void attack();
    void stopAttack();
}

class SoldierUnit implements ArmedUnit{
    private Commander commander;
    public SoldierUnit(Commander commander){
        this.commander=commander;
    }
    @Override
    public void attack()
    {
      if(commander.canAttack())
      {
          System.out.println("SoldierUnit: Attacking.....");
          commander.setAttackStatus(false);
      }
       else{
          System.out.println("SoldierUnit: Cannot attack now. Other units attacking....");
      }
    }
    @Override
    public void  stopAttack(){
        System.out.println("SoldierUnit: Stopped Attacking.....");
        commander.setAttackStatus(true);
    }
}

class TankUnit implements ArmedUnit{
    private Commander commander;
    public TankUnit(Commander commander){
        this.commander=commander;
    }
    @Override
    public void  attack()
    {
        if(commander.canAttack())
        {
            System.out.println("TankUnit: Attacking.....");
            commander.setAttackStatus(false);
        }
        else{
            System.out.println("TankUnit: Cannot attack now. Other units attacking....");
        }
    }
    @Override
    public void  stopAttack(){
        System.out.println("TankUnit: Stopped attacking.....");
        commander.setAttackStatus(true);
    }
}