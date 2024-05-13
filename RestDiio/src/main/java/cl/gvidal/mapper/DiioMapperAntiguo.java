package cl.gvidal.mapper;

import cl.gvidal.DTO.DiioDto;
import cl.gvidal.model.Diio;

public class DiioMapperAntiguo {
	
	//Asi se mapeaba un objeto antiguamente
	public static DiioDto diioToDiioDto(Diio diio) {
		DiioDto arete = new DiioDto();
		arete.setId(diio.getId());
		arete.setNroDiio(diio.getNroDiio());
		arete.setFechaNacimiento(diio.getFechaNacimiento());
		arete.setFechaInstall(diio.getFechaInstall());
		arete.setDesc(diio.getDesc());
		arete.setCampo_id(diio.getCampo().getId());
		arete.setCampo_direccion(diio.getCampo().getDireccion());
		arete.setCampo_rup(diio.getCampo().getRup());
		
		return arete;
	}
}
