package com.gamecenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamecenter.dto.MetricsEmpresaDTO;
import com.gamecenter.metrics.EmpresaCounterSingleton;
import com.gamecenter.metrics.EmpresaDeleteCounterSingleton;
import com.gamecenter.metrics.EmpresaPostCounterSingleton;

@RestController
@RequestMapping(value = "gamecenter")
public class MetricsController {
	@Autowired
	public MetricsController() {
	}

	@GetMapping(value = "/metrics")
	public ResponseEntity<MetricsEmpresaDTO> obterMetricEmpresa() {
		int valorGetEmpresa = EmpresaCounterSingleton.INSTANCE.getValor();
		int valorDelEmpresa = EmpresaDeleteCounterSingleton.INSTANCE.getValor();
		int valorPostEmpresa = EmpresaPostCounterSingleton.INSTANCE.getValor();
		
		MetricsEmpresaDTO metricsEmpresa = new MetricsEmpresaDTO();
		metricsEmpresa.setGetEmpresaCounter(valorGetEmpresa);
		metricsEmpresa.setDelEmpresaCounter(valorDelEmpresa);
		metricsEmpresa.setPostEmpresaCounter(valorPostEmpresa);
		
		return new ResponseEntity<>(metricsEmpresa, HttpStatus.OK);
	}
}
