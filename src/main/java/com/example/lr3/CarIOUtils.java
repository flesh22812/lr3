package com.example.lr3;

import java.io.*;
import java.util.Arrays;

public class CarIOUtils {

    public static void outputCar(Car o, OutputStream out) throws IOException {
        o.output(out);
    }

    public static Car inputCar(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);

        String name = inputName(dis);

        double price = dis.readDouble();
        int arrSize = dis.readInt();
        double[] speed = new double[arrSize];
        for (int i = 0; i < arrSize; i++) {
            speed[i] = dis.readDouble();
        }
        try {

            return new Car(name, price, speed);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeCar(Car o, Writer out) throws IOException {
        o.write(out);
    }


    public static Car readCar(Reader in) throws IOException, Ex {
        BufferedReader reader = (BufferedReader) in;
        String lineFromFile = reader.readLine();
        if (lineFromFile == null) throw new Ex(Ex.CORRECT_DATA);
        lineFromFile = lineFromFile.replaceAll(",", ".");
        String[] tokens = lineFromFile.split(" ");


        String name = tokens[0];
        double price = Double.parseDouble(tokens[1]);
        int arrSize = Integer.parseInt(tokens[2]);
        double[] speed = new double[arrSize];
        for (int i = 0; i < arrSize; i++) {
            speed[i] = Double.parseDouble(tokens[i + 2]);
        }


        return new Car(name, price, speed);


    }

    public static void serializeCar(Car o, OutputStream out) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);
    }

    public static Car deserializeCar(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(in);
        return (Car) ois.readObject();
    }

    private static String inputName(DataInputStream dis) throws IOException {
        int nameSize = dis.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nameSize; i++) {
            sb.append(dis.readChar());
        }
        return sb.toString();
    }

    public static Car readCarTokenizer(Reader in) throws IOException {

        StreamTokenizer st = new StreamTokenizer(in);
        st.parseNumbers();

        st.nextToken();

        String name = st.sval;
        st.nextToken();
        double price = st.nval;
        st.nextToken();
        int arrSize = (int) st.nval;
        double[] speed = new double[arrSize];
        for (int i = 0; i < arrSize; i++) {
            st.nextToken();
            speed[i] = st.nval;
        }


        return new Car(name, price, speed);
    }
}

