package br.com.augusto.view.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.augusto.domain.Estado;
import br.com.augusto.repository.EstadoRepositoryImpl;

@FacesConverter(forClass = Estado.class)
public class EstadoConverte implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				return new EstadoRepositoryImpl().buscarPorId(Long.valueOf(value));

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Estado não valido."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			return String.valueOf(((Estado) object).getId());
		} else {
			return null;
		}
	}

}
