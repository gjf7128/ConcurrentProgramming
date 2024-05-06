public class ResourceBank {

    private int goldAmount;

    private int woodAmount;

    private int foodAmount;

    public ResourceBank() {
        this.goldAmount = 0;
        this.woodAmount = 0;
        this.foodAmount = 0;
    }

    public int getGoldAmount() {
        return goldAmount;
    }

    public void setGoldAmount(int amount) {
        this.goldAmount = amount;
    }

    public int getWoodAmount() {
        return woodAmount;
    }

    public void setWoodAmount(int amount) {
        this.woodAmount = amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int amount) {
        this.foodAmount = amount;
    }
}
