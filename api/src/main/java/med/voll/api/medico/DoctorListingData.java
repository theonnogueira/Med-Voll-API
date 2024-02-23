package med.voll.api.medico;

public record DoctorListingData(
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public DoctorListingData(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
