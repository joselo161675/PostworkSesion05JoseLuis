package com.example.postworksesion05joseluis;


        import com.example.postworksesion05joseluis.Model.Persona;
        import com.example.postworksesion05joseluis.Service.FormateadorTelefono;
        import com.example.postworksesion05joseluis.Service.ValidadorTelefono;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

        import java.util.Scanner;

@SpringBootApplication
public class PostworkSesion05JoseLuisApplication implements CommandLineRunner {

    private final ValidadorTelefono validadorTelefono;
    private final FormateadorTelefono formateadorTelefono;

    @Autowired
    public PostworkSesion05JoseLuisApplication(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
        this.validadorTelefono = validadorTelefono;
        this.formateadorTelefono = formateadorTelefono;
    }

    public static void main(String[] args) {
        SpringApplication.run(PostworkSesion05JoseLuisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String nombre = reader.nextLine();

        System.out.println("Introduce el teléfono: ");
        String telefono = reader.nextLine();

        if (validadorTelefono.isValido(telefono)) {
            telefono = validadorTelefono.limpiaNumero(telefono);
            telefono = formateadorTelefono.formatea(telefono);

            Persona persona = new Persona(nombre, telefono);

            System.out.println(persona);
        } else {
            System.out.println("Por favor, introduce un número válido");
        }
    }
}

