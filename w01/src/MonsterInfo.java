public class MonsterInfo {
    private final String[] monsters;

    public MonsterInfo() {
        this.monsters = new String[] {
            "\uD83E\uDD83", // 칠면조
            "\uD83E\uDD87", // 박쥐
            "\uD83D\uDC38", // 개구리
            "\uD83E\uDD82", // 전갈
            "\uD83D\uDC33", // 고래
            "\uD83D\uDC0C", // 달팽이
        };
    }

    public String getMonster(int idx) {
        return monsters[idx];
    }

    public int getMosterListSize() {
        return this.monsters.length;
    }
}
