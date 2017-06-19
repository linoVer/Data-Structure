package lde;

public interface ILista<Tipo> {
	
	public boolean adicionar(Tipo valor);
    public boolean adicionar(int posicao, Tipo valor);
    public Tipo obter(int posicao);
    public Tipo remover(int posicao);
    public boolean removerContem(Tipo valor);
    public boolean contem(Tipo valor);
    public int tamanho();
    public void limpar();

}
