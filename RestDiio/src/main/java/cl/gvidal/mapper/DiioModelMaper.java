package cl.gvidal.mapper;

import cl.gvidal.DTO.DiioDto;
import cl.gvidal.model.Diio;

public interface DiioModelMaper {

	DiioDto convertToDto(Diio diio);
}
