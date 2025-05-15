package co.edu.uniquindio.proyectohospital.Model;

import co.edu.uniquindio.proyectohospital.Model.CitaMedica;
import co.edu.uniquindio.proyectohospital.Model.Horario;
import co.edu.uniquindio.proyectohospital.Model.Paciente;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Medico medico1 = new Medico(1, "Dr. Pérez", "perez@hospital.com", "Cardiología");
        Paciente paciente1 = new Paciente(101, "Juan López", "juan@correo.com");

        hospital.agregarMedico(medico1);
        hospital.agregarPaciente(paciente1);

        medico1.agregarPaciente(paciente1);

        CitaMedica cita = new CitaMedica(LocalDateTime.now(), paciente1, medico1);


        paciente1.solicitarCita(cita);

        paciente1.notificarCita("Su cita ha sido programada para " + cita.getFechaHora());

        medico1.registrarDiagnostico(paciente1, "Hipertensión controlada");

        medico1.notificarCambioCita(paciente1, "Cambio de horario: ahora es a las 3:00 PM");

        System.out.println(cita.detallesCita());

        System.out.println("Historial Médico de " + paciente1.getNombre() + ": " + paciente1.getHistorial().getAntecedentes());

        System.out.println("Notificaciones de " + paciente1.getNombre() + ": " + paciente1.getNotificaciones());

        System.out.println("\nResumen del hospital:");
        System.out.println("Total de médicos: " + hospital.getMedicos().size());
        System.out.println("Total de pacientes: " + hospital.getPacientes().size());
    }
}

