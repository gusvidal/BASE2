package cl.gvidal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import cl.gvidal.DTO.DiioDto;
import cl.gvidal.model.Diio;

public class DiioModelMapper {

	 @Autowired
	 private ModelMapper modelMapper;
	 
	//Hace el mapeo de una Entity (Diio) a un Dto (DiioDto) con model mapper
    public DiioDto convertToDto(Diio diio) {
    	DiioDto diioDto = modelMapper.map(diio, DiioDto.class);
		diioDto.setCampo_id(diio.getCampo().getId());
		diioDto.setCampo_direccion(diio.getCampo().getDireccion());
    	//diioDto.setCampo_nombre(diio.getCampo().getDireccion());
    	diioDto.setCampo_rup(diio.getCampo().getRup());
    	
        return diioDto;
    }
}
