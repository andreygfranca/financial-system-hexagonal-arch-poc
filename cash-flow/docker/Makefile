SHELL = /bin/bash

VERSION ?= $(shell git describe --tags --abbrev=0)
IMAGE ?= andreygfranca/cash-flow
ROOTPATH ?= $(shell git rev-parse --show-toplevel)
TMP_DIR := "$(shell mktemp -d $(ROOTPATH)/cash-flow/tmp.build.XXXXXXXXXX)"
ARTIFACTS ?= "$(shell git rev-parse --show-toplevel)/cash-flow/cash-flow-bootloader/target/cash-flow.jar"
DOCKERPATH ?= "$(shell git rev-parse --show-toplevel)/cash-flow/docker"
BRANCH ?= $(shell git name-rev --name-only HEAD)

# Define here the list of images that should be builded
LIST_OF_IMAGES_TO_BUILD := $(IMAGE)
export

# ensure that latest isn't use for build
define isLatest
	@[ $(VERSION) != "latest" ] || (echo "VERSION can't be latest in $(@)"; exit 1)
endef

# Rule "build:latest"
.PHONY: build\:latest
build\:latest:
	cp -R $(ARTIFACTS) $(TMP_DIR)
	cp -R $(DOCKERPATH)/* $(TMP_DIR)
	cd $(TMP_DIR)
	docker build --force-rm \
		-t "$(IMAGE)":latest \
		--build-arg CURRENT_BRANCH=$(BRANCH) \
		$(TMP_DIR)
	sleep 0.2
	rm -rf $(TMP_DIR)

# Rule "build"
.PHONY: build
build:
	$(call isLatest)
	cp -R $(ARTIFACTS) $(TMP_DIR)
	cp -R $(DOCKERPATH)/* $(TMP_DIR)
	cd $(TMP_DIR)
	docker build --force-rm \
		--no-cache -t $(IMAGE):$(VERSION) \
		--build-arg CURRENT_BRANCH=$(BRANCH) \
		$(TMP_DIR)
	sleep 0.2
	rm -rf $(TMP_DIR)
