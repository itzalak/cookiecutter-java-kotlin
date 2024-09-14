# Makefile

checkmark=\xE2\x9C\x94  # Unicode character representation
warning=\xE2\x9A\xA0  # Unicode character representation

define warn
	@tput bold
	@tput setaf 3
	@printf "${warning}${1}\n"
	@tput sgr0
endef

define log
	@tput bold
	@tput setaf 6
	@printf "${checkmark}${1}\n"
	@tput sgr0
endef

.DEFAULT_GOAL := help
ROOT_DIR := $(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
VENV := .venv

###############################################################################
# Default
###############################################################################

.PHONY: help
help:
	@echo "|> Directory: ${ROOT_DIR}"
	@echo "|> OS: ${OS}"
	@echo "|> Available targets:"
	@make -qpRr | grep -E '^[a-z].*:$$' | sed -e 's~:~~g' | sort

.PHONY: all
all: clean install
	@$(call warn, all)

.PHONY: install
install: pre-commit-setup
	@$(call warn, setup)

.PHONY: update
update: pre-commit-update
	@$(call warn, update)

.PHONY: test
test:
	@$(call warn, test)
	./gradew test

.PHONY: clean
clean:
	@$(call warn, clean)
	@$(call log, dummy call)

###############################################################################
# Pre commit
###############################################################################

pre-commit: pre-commit-setup pre-commit-update

pre-commit-setup:
	@$(call warn, install pre-commit dependencies)
	pre-commit install
	@$(call log, install pre-commit dependencies)

pre-commit-update:
	@$(call warn, update pre-commit dependencies)
	pre-commit autoupdate
	@$(call log, update pre-commit dependencies)

###############################################################################
# Commitizen
###############################################################################

bump:
	@$(call warn, bump version of commitizen)
	cz bump
	@$(call log, Dont forget to push the tags)
	@$(call log, git push --tags)
