package ar.edu.unju.escmi.tp8.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.escmi.tp8.collections.CollectionEmpresa;
import ar.edu.unju.escmi.tp8.model.Empresa;
import ar.edu.unju.escmi.tp8.service.IEmpresaService;

@Service
public class EmpresaServiceImp implements IEmpresaService {

	@Override
	public void guardarEmpresa(Empresa empresa) {
		CollectionEmpresa.empresas.add(empresa);
		System.out.println("empresa guardada! " + empresa);
	}

	@Override
	public List<Empresa> obtenerEmpresas() {
		return CollectionEmpresa.empresas;
	}

	@Override
	public void modificarEmpresa(Empresa empresa) {
		for (Empresa emp : CollectionEmpresa.empresas) {
			if (emp.getId() == empresa.getId()) {
				emp.setNombre(empresa.getNombre());
				emp.setCantidadEmpleados(empresa.getCantidadEmpleados());
				emp.setTelefono(empresa.getTelefono());
				emp.setDireccion(empresa.getDireccion());
				System.out.println("Se modificó la empresa: " + emp);
			}
		}
	}

	@Override
	public void eliminarEmpresa(int id) {
		Optional<Empresa> emp = CollectionEmpresa.empresas.stream().filter(e -> e.getId() == id).findFirst();
		if (emp.isPresent()) {
			CollectionEmpresa.empresas.remove(emp.get());
			System.out.println("se eliminó la empresa con id " + id);
		}
	}

	@Override
	public Empresa buscarEmpresaId(int id) {
		Optional<Empresa> emp = CollectionEmpresa.empresas.stream().filter(e -> e.getId() == id).findFirst();
		return emp.isPresent() ? emp.get() : null;
	}
}