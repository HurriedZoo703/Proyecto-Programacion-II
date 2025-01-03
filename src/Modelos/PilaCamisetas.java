package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;
import javafx.scene.control.Alert;

public class PilaCamisetas {

    private final Stack<NodoCamiseta> pilaB;
    private final Stack<NodoCamiseta> pilaLD;

    public PilaCamisetas() {
        this.pilaB = new Stack<>();
        this.pilaLD = new Stack<>();
    }

    public Stack<NodoCamiseta> getPilaB() {
        return pilaB;
    }

    public Stack<NodoCamiseta> getPilaLD() {
        return pilaLD;
    }

    //Metodos PilaB
    public void setPush(NodoCamiseta c) {
        int pos = pilaB.indexOf(c);
        if (pos == -1) {
            pilaB.push(c);
        } else {
            System.out.println("Ya se encontraba registrada la camiseta");
        }
    }

    public Stack<NodoCamiseta> getCamisetas(int id) {
        Stack<NodoCamiseta> pila = new Stack<>();
        for (NodoCamiseta aux : pilaB) {
            if (aux.getIdPropietario() == id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public NodoCamiseta getCamiseta(int id, String color) {
        for (NodoCamiseta aux : pilaB) {
            if (aux.getIdPropietario() == id && aux.getColor().equals(color)) {
                return aux;
            }
        }
        return null;
    }

    public void popCamiseta(int id, String color) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        NodoCamiseta aux = null;
        if (!pilaB.empty()) {
            aux = getCamiseta(id, color);
            if ((aux != null) && (pilaB.remove(aux))) {
                System.out.println("Camiseta eliminda.");
            } else {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("La camiseta no existe.");
                alert.showAndWait();
            }
        } else {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aviso.");
            alert.setContentText("No hay camisetas registradas");
            alert.showAndWait();
        }
    }

    public Stack<NodoCamiseta> getClonarB() {
        Stack<NodoCamiseta> caux = new Stack<>();
        int i;
        NodoCamiseta aux = null;
        if (this.pilaB == null) {
            return null;
        } else {
            for (i = 0; i < pilaB.size(); i++) {
                aux = pilaB.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar(int id, String color) {
        Stack<NodoCamiseta> temp = new Stack<>();

        while (!pilaB.isEmpty()) {
            NodoCamiseta camiseta = pilaB.pop();
            if (!(camiseta.getIdPropietario() == id && camiseta.getColor().equals(color))) {
                temp.push(camiseta);
            }
        }
        while (!temp.isEmpty()) {
            pilaB.push(temp.pop());
        }
    }

    //Metodos PilaLD
    public void setPushLD(NodoCamiseta c) {
        int pos = pilaLD.indexOf(c);
        if (pos == -1) {
            pilaLD.push(c);
        } else {
            System.out.println("Ya se encontraba registrada la camiseta");
        }
    }

    public Stack<NodoCamiseta> getCamisetasLD(int id) {
        Stack<NodoCamiseta> pila = new Stack<>();
        for (NodoCamiseta aux : pilaLD) {
            if (aux.getIdPropietario() == id) {
                pila.push(aux);
            }
        }
        return pila;
    }

    public NodoCamiseta getCamisetaLD(int id, String color) {
        for (NodoCamiseta aux : pilaLD) {
            if (aux.getIdPropietario() == id && aux.getColor().equals(color)) {
                return aux;
            }
        }
        return null;
    }

    public void popCamisetaLD(int id, String color) {
        Alert alert = new Alert(Alert.AlertType.NONE);

        NodoCamiseta aux = null;
        if (!pilaLD.empty()) {
            aux = getCamisetaLD(id, color);
            if ((aux != null) && (pilaLD.remove(aux))) {
                System.out.println("Camiseta elminada");
            } else {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Aviso.");
                alert.setContentText("La camiseta no existe.");
                alert.showAndWait();
            }
        } else {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aviso.");
            alert.setContentText("No hay camisetas registradas");
            alert.showAndWait();
        }
    }

    public Stack<NodoCamiseta> getClonarLD() {
        Stack<NodoCamiseta> caux = new Stack<>();
        int i;
        NodoCamiseta aux = null;
        if (this.pilaLD == null) {
            return null;
        } else {
            for (i = 0; i < pilaLD.size(); i++) {
                aux = pilaLD.get(i);
                caux.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminarLD(int id, String color) {
        Stack<NodoCamiseta> temp = new Stack<>();

        while (!pilaLD.isEmpty()) {
            NodoCamiseta camiseta = pilaLD.pop();
            if (!(camiseta.getIdPropietario() == id && camiseta.getColor().equals(color))) {
                temp.push(camiseta);
            }
        }
        while (!temp.isEmpty()) {
            pilaLD.push(temp.pop());
        }
    }

    public void guardarCamisetas() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_TXT\\CamisetasBolsa.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<NodoCamiseta> camiAux = pilaB;

            for (NodoCamiseta camiseta : camiAux) {
                writer.write(camiseta.getIdPropietario() + ", ");
                writer.write(camiseta.getColor() + ", ");
                writer.write(camiseta.getURL_ima());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: CamisetasBolsa.txt: " + e.getMessage());
        }
    }

    public void cargarCamisetas() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_TXT\\CamisetasBolsa.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaB.isEmpty()) {
                pilaB.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                int idPropietario = Integer.parseInt(atributos[0]);
                String color = atributos[1];
                String URL = atributos[2];

                NodoCamiseta camiseta = new NodoCamiseta(idPropietario, color, URL);

                setPush(camiseta);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde CamisetasBolsa.txt: " + e.getMessage());
        }
    }

    public void guardarCamisetasLD() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_TXT\\CamisetasDeseos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<NodoCamiseta> camiAux = pilaLD;

            for (NodoCamiseta camiseta : camiAux) {
                writer.write(camiseta.getIdPropietario() + ", ");
                writer.write(camiseta.getColor() + ", ");
                writer.write(camiseta.getURL_ima());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en: CamisetasDeseos.txt: " + e.getMessage());
        }
    }

    public void cargarCamisetasLD() {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_TXT\\CamisetasDeseos.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaLD.isEmpty()) {
                pilaLD.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                int idPropietario = Integer.parseInt(atributos[0]);
                String color = atributos[1];
                String URL = atributos[2];

                NodoCamiseta camiseta = new NodoCamiseta(idPropietario, color, URL);

                setPushLD(camiseta);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde CamisetasDeseos.txt: " + e.getMessage());
        }
    }

}
