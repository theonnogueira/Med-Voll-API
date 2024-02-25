package med.voll.api.paciente;

public record PatientListingData(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public PatientListingData(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
