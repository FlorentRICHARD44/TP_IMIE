package fr.imie.presentation;

public class Launcher {

    private Launcher() {
        // TODO Auto-generated constructor stub
    }
    public static void main(final String[] args) {
        try (IHMConsole ihm = new IHMConsole()) {
            ihm.run();
            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Add better catch
        }
    }
}