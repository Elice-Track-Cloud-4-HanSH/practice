public class GameRule {
  InputData inptData;
  MonsterInfo monsterInfo;
  private final int ATTACK_NUM = 1;
  private final int PORTION_NUM = 2;
  private final int RUNAWAY_NUM = 3;

  public GameRule() {
    this.inptData = new InputData();
    this.monsterInfo = new MonsterInfo();
  }

  public void encounterMonster(User player) {
    if ((int)(Math.random() * 10) == 3) {
      System.out.println("몬스터를 만나지 못하였습니다...");
      return;
    }
    int actionNum = -1;
    boolean cond = true;
    int monsterIdx = (int)(Math.random() * monsterInfo.getMosterListSize());
    int monsterHp = (int)(Math.random() * 40) + 10;
    String monsterImoji = this.monsterInfo.getMonster(monsterIdx);
    System.out.println(monsterImoji + "를 만났습니다!\n");
    while (cond) {
      System.out.println(
                "플레이어 체력: %d\n".formatted(player.getHp()) +
                "몬스터 체력 : %d\n".formatted(monsterHp));
      actionNum = this.inptData.getActionNum();

      switch (actionNum) {
        case ATTACK_NUM:
          int playerAttackDamage = (int)(Math.random() * 20) + 1 + player.getDamageFactor();
          int monsterAttackDamage = (int)(Math.random() * 20) + 1;
          monsterHp -= playerAttackDamage;
          player.appendHp(-monsterAttackDamage);
          if (monsterHp <= 0) {
            cond = false;
            player.appendKillScore(1);
            if (monsterHp == 0) {
              System.out.println("전리품으로 포션 1개를 획득하였습니다.");
              player.appendPortionCount(1);
            }
            else if ((int)(Math.random() * 2) == 1) {
              System.out.println("전리품으로 포션 1개를 획득하였습니다.");
              player.appendPortionCount(1);
            }
          }
          if (player.getHp() <= 0) {
            cond = false;
          }
          System.out.println(" >> 플레이어는 %d의 피해를 입었습니다.\n >> %s는 %d의 피해를 입었습니다.\n".formatted(monsterAttackDamage, monsterImoji, playerAttackDamage));
          break;
        case PORTION_NUM:
          // 10~60 운빨 회복
          if (player.getPositionCount() >= 0) {
            int recoveryHpAmount = (int)(Math.random() * 50) + 10;
            player.appendHp(recoveryHpAmount);
            player.appendPortionCount(-1);
            System.out.println("\uD83E\uDDEA: %d만큼 회복되었습니다. (잔여 포션 %d개)".formatted(recoveryHpAmount, player.getPositionCount()));
          }
          break;
        case RUNAWAY_NUM:
          cond = false;
          break;
      }
    }
    System.out.println("전투가 종료되었습니다. 플레이어의 남은 체력은 %d 입니다.".formatted(player.getHp()));
  }
}
