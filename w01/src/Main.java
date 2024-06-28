public class Main {
    private static final int EXIT_NUM = 2;

    public static void main(String[] args) {
        User player = new User();
        MonsterInfo monster = new MonsterInfo();
        InputData inptData = new InputData();
        GameRule gameRule = new GameRule();

        int menuNum = 0;
        int randNum = 0;

        System.out.println("\uD83D\uDC30 : 당신은 모험 도중 '몬스터 4마리 잡기'라는 퀘스트를 받았습니다.");
        while (player.getHp() > 0 && player.getKillScore() < 4) {
            menuNum = inptData.getMenuNum();
            if (menuNum == EXIT_NUM)
                break;

            randNum = (int)(Math.random() * 10) + 1;
            switch (randNum) {
                case 4:
                    int damaged = (int)(Math.random() * 5);
                    System.out.println("수풀을 지나는 도중 독이 있는 가시에 찔리고 말았습니다.\n" + "중독될만큼의 독은 아니지만, 몸이 약해지는 것을 느꼈습니다.");
                    player.appendHp(-damaged);
                    player.appendDamageFactor(-1);
                    System.out.println("\t체력이 %d 감소합니다.\n\t최종 대미지가 1만큼 감소합니다.".formatted(damaged));
                    break;
                case 7:
                    int healed = (int)(Math.random() * 5);
                    System.out.println("수풀을 지나는 도중 약초를 찾아냈습니다!\n" + "약초학을 배운 당신은 체력을 회복하고 남은 약초로 포션을 만들었습니다.");
                    player.appendHp(healed);
                    player.appendDamageFactor(1);
                    player.appendPortionCount(1);
                    System.out.println("\t체력이 %d 증가합니다.\n\t최종 대미지가 1만큼 증가합니다.".formatted(healed));
                    break;
                default:
                    gameRule.encounterMonster(player);
                    break;
            }
        }
        if (player.getKillScore() >= 4) {
            if (player.getHp() <= 0) {
                System.out.println("방랑자가 쓰러져있는 당신을 발견했습니다.");
                System.out.println("방랑자의 도움으로 근처 마을에서 치료를 받아 살아날 수 있었습니다.");
            }
            System.out.println("플레이어의 승리입니다!");
        }
        else if (player.getHp() <= 0) {
            System.out.println("당신은 할당량인 4마리를 전부 잡지 못하였습니다.\n잡은 몬스터의 수는 %d마리 입니다.\n패배하셨습니다...".formatted(player.getKillScore()));
        } else {
            System.out.println("당신은 출처가 불명확한 퀘스트를 무시하기로 하였습니다.\n안전한게 제일 좋잖아요?");
        }
    }
}