package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "unidade", nullable = false)
    private String unidade;
    
    @Column(name = "preco", nullable = false)
    private Double preco;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "descricao", nullable = false)
	private String descricao;

	public Produto(){}

	public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }  

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getUnidade(){
		return unidade;
	}

	public void setUnidade(String unidade){
		this.unidade = unidade;
	}

	public Double getPreco(){
		return preco;
	}

	public void setPreco(Double preco){
		this.preco = preco;
	}

	public Integer getQuantidade(){
		return quantidade;
	}

	public void setQuantidade(Integer quantidade){
		this.quantidade = quantidade;
	}

	public String getDescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}