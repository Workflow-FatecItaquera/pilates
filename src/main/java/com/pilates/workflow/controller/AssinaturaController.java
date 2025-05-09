package com.pilates.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pilates.workflow.model.Assinatura;
import com.pilates.workflow.service.AssinaturaService;

@RestController
public class AssinaturaController {
	
	@Autowired
	private AssinaturaService assinaturaService;
	
	@GetMapping("/backend/assinaturas")
	public List<Assinatura> getAllAssinaturas(){
		return assinaturaService.getAll();
	}
	
	@GetMapping("/backend/assinatura/{id}")
	public Assinatura getById(@PathVariable String id) {
		return assinaturaService.getById(id);
	}
	
	@PostMapping("/backend/assinatura")
	public Assinatura createAssinatura(@RequestBody Assinatura assinatura) {
		return assinaturaService.register(assinatura);
	}
	
	@PutMapping("/backend/assinatura")
	public Assinatura updateAssinatura(@RequestBody Assinatura assinatura) {
		return assinaturaService.register(assinatura);
	}
	
	@DeleteMapping("/backend/assinatura/{id}")
	public String deleteAssinatura(@PathVariable String id) {
		assinaturaService.delete(id);
		return "Assinatura removida com sucesso.";
	}

}
