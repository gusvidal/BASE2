package cl.gvidal.mapper;

import org.mapstruct.Mapper;

import cl.gvidal.DTO.DiioDto;
import cl.gvidal.model.Diio;

@Mapper(componentModel = "spring")
public interface DiioMapperMapStruct {

	Diio DiioDtoToDiio(DiioDto diioDto);
	DiioDto DiioToDiioDto(Diio diio);
}
