package br.com.fiap3espa.AutoEscola_3ESPA.instrutor;

public record DadosListagemInstrutor(
        String nome,
        String email,
        String cnh,
        Especialidade especialidade)
{
    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
    }
}
