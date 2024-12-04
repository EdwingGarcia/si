package com.Edwing.Garcia.Mini.Core.miniCore.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Edwing.Garcia.Mini.Core.miniCore.model.Contrato;
import com.Edwing.Garcia.Mini.Core.miniCore.repos.ContratoRepository;

@Controller
public class ContratoController {
	@Autowired
	private ContratoRepository contratoRepository;

	@GetMapping("/buscar")
	public String mostrarFormulario(Model model) {
		return "contratos"; // Nombre de la vista HTML
	}

	@PostMapping("/buscarContratos")
	public String buscarContratos(@RequestParam("fechaInicio") LocalDate fechaInicio,
			@RequestParam("fechaFin") LocalDate fechaFin, Model model) {
		// Obtener la suma de montos por cliente
		List<Object[]> resultados = contratoRepository.findSumaMontosPorCliente(fechaInicio, fechaFin);

		model.addAttribute("resultados", resultados);
		return "contratos"; // Regresar a la misma vista
	}

	@GetMapping("/")
	public String mostrarTodosContratos(Model model) {
		List<Contrato> contratos = contratoRepository.findAll(); // Obtener todos los contratos
		model.addAttribute("contratos", contratos);
		return "todosContratos"; // Nombre de la nueva vista
	}
}