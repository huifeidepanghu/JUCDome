import lombok.Getter;

public enum CountryEnum {
    ONE(1,"星期一"),TWO(2,"星期二"),THREE(3,"星期三"),FOUR(4,"星期四"),FIVE(5,"星期五"),SIX(6,"星期六");

     @Getter
     private  Integer recode;
     @Getter private   String reMagger;

    public Integer getRecode() {
        return recode;
    }

    public String getReMagger() {
        return reMagger;
    }

    CountryEnum(Integer recode, String reMagger) {
        this.recode = recode;
        this.reMagger = reMagger;
    }
    public static CountryEnum Foreach_CountryEnum(int index){

        CountryEnum[] myArray =CountryEnum.values();

        for (CountryEnum element: myArray){

            if (index == element.getRecode()){

                return element;
            }
        }

        return null;

    }
}
