package vn.menugo.server.modelDTO;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by itn0309 on 7/15/2017.
 */
public class ModelMapping {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <S,D>  List<D> convertToListDTO(List<S> list,Class<D> destinationType ){
        List<D> newList = new ArrayList<D>();
        Iterator<S> iterator = list.iterator();
        while (iterator.hasNext()) {
           D d = modelMapper.map(iterator.next(),destinationType);
           newList.add(d);
        }
        return  newList;
    }

    public static <D> D convertToDTO(Object source, Class<D> destinationType) {
         return  modelMapper.map(source, destinationType );
    }
}
