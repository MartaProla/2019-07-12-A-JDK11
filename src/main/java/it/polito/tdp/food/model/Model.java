package it.polito.tdp.food.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	private List<Adiacenza>elencoCibi;
	private Graph<String, DefaultWeightedEdge>grafo;
	private FoodDao dao;
	
	
	public Model() {
		this.dao=new FoodDao();
	}
	public void creaGrafo(int x) {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.elencoCibi=this.dao.elencoCibi();
		for(Adiacenza a: elencoCibi) {
			if(a.getPeso()<=x) {
				this.grafo.addVertex(a.getV1());
			}
		}
		System.out.println(String.format("Vertici : %d", this.grafo.vertexSet().size()));
	}

}
