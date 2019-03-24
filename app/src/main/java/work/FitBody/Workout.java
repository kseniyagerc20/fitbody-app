package work.FitBody;

//Класс для записи и вывода данных
//Для дальнейшего использования; создание специальных методов.
class Workout {
    private String name, description, muscleGroup1, muscleGroup2, image, url, technique, inventory;
    private int numberOfViews;

    Workout(String name, String description, String muscleGroup1, String muscleGroup2, int numberOfViews, String image, String url, String technique, String inventory) {
        super();
        this.name = name;
        this.description = description;
        this.muscleGroup1 = muscleGroup1;
        this.muscleGroup2 = muscleGroup2;
        this.numberOfViews = numberOfViews;
        this.image = image;
        this.url = url;
        this.technique = technique;
        this.inventory = inventory;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    String getMuscleGroup1() {
        return this.muscleGroup1;
    }

    String getMuscleGroup2() {
        return this.muscleGroup2;
    }

    int getNumberOfViews() {
        return this.numberOfViews;
    }

    String getImage() {
        return this.image;
    }

    String getUrl() {
        return this.url;
    }

    String getTechnique() { return  this.technique; }

    String getInventory() { return this.inventory; }
}
