package OopCourse.ModuleOne;

import java.util.Scanner;

public class TaskTwoStepFourteen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Material mat = new Material("steel", 7850);
        Thing thing = new Thing("wire", 0.03);
        show(thing.getName(), mat.getDensity(), thing.getVolume());
        double volume = scan.nextDouble();
        Thing thingChanged = new Thing("wire", volume);
        Material matChanged = new Material("copper", 8500);
        show(thingChanged.getName(), matChanged.getDensity(), thingChanged.getVolume());
    }

    public static class Material {
        private static String name;
        private static int density;

        public Material(String name, int density) {
            this.name = name;
            this.density = density;
        }

        public String getName() {
            return name;
        }

        public int getDensity() {
            return density;
        }
    }

    private static class Thing {
        String name;
        String material;
        double volume;

        public Thing(String name, double volume) {
            this.name = name;
            this.material = Material.name;
            this.volume = volume;
        }
        public Thing() {
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setMaterial() {
            this.material = Material.name;
        }
        public void setVolume(Double volume) {
            this.volume = volume;
        }
        public String getName() {
            return name;
        }
        public String getMaterial() {
            return material;
        }
        public double getVolume() {
            return volume;
        }
        public static double getMass(double volume) {
            return Material.density * volume;
        }
    }


    public static void show(String name, int density, double volume) {
        StringBuilder info = new StringBuilder();
        // название вещества = Material.name, название предмета = name, плотность = density, объём = volume, масса = getMass
        info.append(name).append(';').append(Material.name).append(';').append(density).append(';').append(volume).append(';').append(Thing.getMass(volume));
        System.out.println(info);
    }
}
