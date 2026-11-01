package ar.edu.unju.escmi.tp8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	@Autowired
	IEmpresaService empresaService;

	@GetMapping
	public List<Empresa> getEmpresas() {
		return empresaService.obtenerEmpresas();
	}

	@GetMapping("/{id}")
	public Empresa getEmpresaById(@PathVariable int id) {
		return empresaService.buscarEmpresaId(id);
	}

	@PostMapping
	public void addEmpresa(@RequestBody Empresa empresa) {
		empresaService.guardarEmpresa(empresa);
	}

	@PutMapping
	public void updateEmpresa(@RequestBody Empresa empresa) {
		empresaService.modificarEmpresa(empresa);
	}

	@DeleteMapping("/{id}")
	public void deleteEmpresa(@PathVariable int id) {
		empresaService.eliminarEmpresa(id);
	}
}