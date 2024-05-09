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
	@echo "\n|> Directory: ${ROOT_DIR}"
	@echo "|> OS: ${OS}"
	@echo "|> Available targets:\n"
	@make -qpRr | egrep -e '^[a-z].*:$$' | sed -e 's~:~~g' | sort

.PHONY: all
all: clean pre-commit
	@$(call warn, init config)

.PHONY: test
test:
	@$(call warn, dummy)

.PHONY: clean
clean:
	@$(call warn, dummy)

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
