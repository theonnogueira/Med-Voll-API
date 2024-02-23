package med.voll.api.paciente;

public record PatientListingData(
        String nome,
        String email,
        String cpf
) {
    public PatientListingData(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
