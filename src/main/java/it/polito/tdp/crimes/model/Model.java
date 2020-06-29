package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	EventsDao dao;
	Graph<Distretto, DefaultWeightedEdge> graph;
	List<Distretto> dis1;
	
	public Model() {
		dao = new EventsDao();
	}
	
	public List<Integer> anni(){
		return dao.listAnni();
	}
	
	public void creaGrafo(Integer anno) {
		graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		dis1 = dao.distretti(anno);
		
		Graphs.addAllVertices(this.graph, dis1);
		
		for(Distretto v1 : this.graph.vertexSet()) {
			for(Distretto v2 : this.graph.vertexSet()) {
				if(v1.getNumDistretto()!=v2.getNumDistretto()) {
					if(this.graph.getEdge(v1, v2) == null) {
						
						Double dist = LatLngTool.distance(new LatLng(v1.getLat(), v1.getLon()), new LatLng(v2.getLat(), v2.getLon()), LengthUnit.KILOMETER);
						Graphs.addEdge(this.graph, v1, v2, dist);
					}
				}
			}
		}
		System.out.println("N vertici = " + this.graph.vertexSet().size() + " N archi = " + this.graph.edgeSet().size());
	}
	
	public List<Vicino> getVicini(Integer distretto){
		
		Distretto d = null;
		List<Vicino> torna = new ArrayList<Vicino>();
		
		for(Distretto dis : this.graph.vertexSet()) {
			if(dis.getNumDistretto() == distretto) {
				d = new Distretto(dis.getNumDistretto(), dis.getLon(), dis.getLat());
			}
		}
		
		List<Distretto> vic = Graphs.neighborListOf(this.graph, d);
		
		for(Distretto dd : vic) {
			torna.add(new Vicino(dd.getNumDistretto(), this.graph.getEdgeWeight(this.graph.getEdge(d, dd))));
		}
		Collections.sort(torna);	
		
		return torna;
	}
	
	public Set<Distretto> vertici(){
		return this.graph.vertexSet();
	}
	
	
}
