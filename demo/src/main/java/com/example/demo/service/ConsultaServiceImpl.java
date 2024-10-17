package com.example.demo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Consulta;
import com.example.demo.repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    @Override
    public void add(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public void deleteById(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public void update(Consulta consulta) {
        if (consulta.getId() != null && consultaRepository.existsById(consulta.getId())) {
            consultaRepository.save(consulta);
        }
    }

    @Override
    public List<Consulta> findByMascotaId(Long mascotaId) {
        return consultaRepository.findByMascotaId(mascotaId);
    }

    @Override
    public Long getTratamientosUltimoMes() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1); // Ir al mes anterior
        Date inicioMes = calendar.getTime();
    
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date finMes = calendar.getTime();
    
        return consultaRepository.countTratamientosUltimoMes(inicioMes, finMes);
    }

    @Override
    public List<Object[]> getCantidadTratamientosPorDrogaUltimoMes() {
        Date[] fechas = getFechasMesAnterior();
        return consultaRepository.getCantidadTratamientosPorDroga(fechas[0], fechas[1]);
    }

    public Date[] getFechasMesAnterior() {
        Calendar cal = Calendar.getInstance();
    
        // Establecer el primer día del mes anterior
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, -1);
        Date inicio = cal.getTime();
    
        // Establecer el último día del mes anterior a las 23:59:59
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date fin = cal.getTime();
    
        return new Date[]{inicio, fin};
    }    
    
}
