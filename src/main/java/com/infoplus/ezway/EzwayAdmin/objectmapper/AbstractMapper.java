package com.infoplus.ezway.EzwayAdmin.objectmapper;

import java.util.List;
import java.util.Set;

public interface AbstractMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntities(List<D> dtos);

    List<D> toDtos(List<E> entities);

    Set<E> toEntities(Set<D> dtos);

    Set<D> toDTOs(Set<E> entities);

}
