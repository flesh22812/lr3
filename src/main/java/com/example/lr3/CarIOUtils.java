package com.example.lr3;

import com.example.lr3.factory.CarFactory;
import com.example.lr3.factory.TruckFactory;
import com.example.lr3.interfaces.ICar;
import com.example.lr3.interfaces.ICarFactory;
import com.example.lr3.threads.SyncCar;

import java.io.*;

public class CarIOUtils {
    private static final ICarFactory carFactory = new CarFactory();
    private static final ICarFactory truckFactory = new TruckFactory();
    private static ICarFactory factory = carFactory;

    public static ICar synchronizedCar(ICar car){
        return new SyncCar(car);
    }
    public static void setCarFactory(ICarFactory cf) {
        factory = cf;
    }

    public static void outputCar(ICar o, OutputStream out) throws IOException {
        o.output(out);
    }

    public static ICar inputCar(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);

        String name = inputName(dis);

        double price = dis.readDouble();
        int arrSize = dis.readInt();
        double[] speed = new double[arrSize];
        for (int i = 0; i < arrSize; i++) {
            speed[i] = dis.readDouble();
        }
        try {
            if (price > 100000) {
             setCarFactory(carFactory);
            }else {setCarFactory(truckFactory);
            }
            return factory.createInstance(name, speed, price);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeCar(ICar o, Writer out) throws IOException {
        o.write(out);
    }


    public static ICar readCar(Reader in) throws IOException, Ex {
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
        if (price > 100000) {
            setCarFactory(carFactory);
        }else {setCarFactory(truckFactory);
        }
        return factory.createInstance(name, speed, price);

    }

    public static void serializeCar(ICar o, OutputStream out) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(o);
    }

    public static ICar deserializeCar(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(in);
        return (ICar) ois.readObject();
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

