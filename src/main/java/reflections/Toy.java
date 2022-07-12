package reflections;

class Toy {
    public String name;
    protected int id;
    private String typeToy;

    public Toy() {
    }

    public Toy(String name, int id) {
        this.name = name;
        this.id = id;
        this.typeToy = "small";
    }

    private Toy(String name, int id, String typeToy) {
        this.name = name;
        this.id = id;
        this.typeToy = typeToy;
    }

    public String say() {
        return "Toy -> say";
    }

    private boolean isrRndNumChoose() throws NullPointerException {
        return (int) (Math.random() * 10) == (int) (Math.random() * 10);
    }
}
