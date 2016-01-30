import business.Input;
import business.Process;

import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        File file = new File("src//main//resources//teste.txt");
        Input in = new Input();
        Process process = new Process();
        process.output(in.readFile(file));

    }
}
