public class User {
    private int portionCount;
    private int damageFactor;
    private int hp;
    private int killScore;

    public User() {
        this.portionCount = 3;
        this.damageFactor = 0;
        this.hp = 100;
        this.killScore = 0;
    }
    
    public void appendPortionCount(int pos) {
        this.portionCount += pos;
    }
    
    public int getPositionCount() {
        return this.portionCount;
    }

    public void appendDamageFactor(int factor) {
        this.damageFactor += factor;
    }

    public int getDamageFactor() {
        return this.damageFactor;
    }

    public void appendHp(int hp) {
        this.hp += hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void appendKillScore(int score) {
        this.killScore += score;
    }

    public int getKillScore() {
        return this.killScore;
    }
}
