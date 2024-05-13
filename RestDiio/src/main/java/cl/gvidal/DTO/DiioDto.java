package cl.gvidal.DTO;

public class DiioDto {
	private int id;
    private String nroDiio;
    private String fechaInstall;
    private String desc;
    private String fechaNacimiento;
    private int campo_id;
    private String campo_direccion;
    private String campo_rup;

	public DiioDto(int id, String nroDiio, String fechaInstall, String desc, String fechaNacimiento, int campo_id,
			String campo_direccion, String campo_rup) {
		super();
		this.id = id;
		this.nroDiio = nroDiio;
		this.fechaInstall = fechaInstall;
		this.desc = desc;
		this.fechaNacimiento = fechaNacimiento;
		this.campo_id = campo_id;
		this.campo_direccion = campo_direccion;
		this.campo_rup = campo_rup;
	}

	public DiioDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNroDiio() {
		return nroDiio;
	}

	public void setNroDiio(String nroDiio) {
		this.nroDiio = nroDiio;
	}

	public String getFechaInstall() {
		return fechaInstall;
	}

	public void setFechaInstall(String fechaInstall) {
		this.fechaInstall = fechaInstall;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCampo_id() {
		return campo_id;
	}

	public void setCampo_id(int campo_id) {
		this.campo_id = campo_id;
	}

	public String getCampo_direccion() {
		return campo_direccion;
	}

	public void setCampo_direccion(String campo_direccion) {
		this.campo_direccion = campo_direccion;
	}

	public String getCampo_rup() {
		return campo_rup;
	}

	public void setCampo_rup(String campo_rup) {
		this.campo_rup = campo_rup;
	}

}
