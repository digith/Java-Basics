package com.digithkv.java.basics.designpatterns.creational;

import java.time.LocalDate;

public class BuilderDesignPattern {
	public static void main(String[] args) {
		Phone.PhoneBuilder.builder().setName("Samsung").setMemory(32_000_000_000.0)
		.setModel("S22").build();
	}
}

class Phone {
	private String name, model;
	private Double price, memory, storage;
	private LocalDate warrantyDate;
	private Object addons;

	public Phone(String name, String model, Double price, Double memory, Double storage, LocalDate warrantyDate,
			Object addons) {
		super();
		this.name = name;
		this.model = model;
		this.price = price;
		this.memory = memory;
		this.storage = storage;
		this.warrantyDate = warrantyDate;
		this.addons = addons;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	public Double getPrice() {
		return price;
	}

	public Double getMemory() {
		return memory;
	}

	public Double getStorage() {
		return storage;
	}

	public LocalDate getWarrantyDate() {
		return warrantyDate;
	}

	public Object getAddons() {
		return addons;
	}

	public static class PhoneBuilder {
		private String name, model;
		private Double price, memory, storage;
		private LocalDate warrantyDate;
		private Object addons;

		public String getName() {
			return name;
		}

		public static PhoneBuilder builder() {
			return new PhoneBuilder();
		}

		private PhoneBuilder() {
		}

		public PhoneBuilder setName(String name) {
			this.name = name;
			return this;
		}

		private String getModel() {
			return model;
		}

		public PhoneBuilder setModel(String model) {
			this.model = model;
			return this;
		}

		private Double getPrice() {
			return price;
		}

		public PhoneBuilder setPrice(Double price) {
			this.price = price;return this;
		}

		private Double getMemory() {
			return memory;
		}

		public PhoneBuilder setMemory(Double memory) {
			this.memory = memory;return this;
		}

		private Double getStorage() {
			return storage;
		}

		public PhoneBuilder setStorage(Double storage) {
			this.storage = storage;return this;
		}

		private LocalDate getWarrantyDate() {
			return warrantyDate;
		}

		public PhoneBuilder setWarrantyDate(LocalDate warrantyDate) {
			this.warrantyDate = warrantyDate;return this;
		}

		private Object getAddons() {
			return addons;
		}

		public PhoneBuilder setAddons(Object addons) {
			this.addons = addons;return this;
		}

		public Phone build() {
			return new Phone(this.getName(), this.getModel(), this.getPrice(), this.getMemory(), this.getStorage(),
					this.getWarrantyDate(), this.getAddons());
		}
	}
}