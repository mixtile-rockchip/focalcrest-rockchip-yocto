# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

require conf/machine/include/rk3588.inc
require conf/machine/include/focalcrest-common.inc

MACHINEOVERRIDES =. "focalcrest-rk3588:"

# Unlike focalcrest-rk3588s.inc, SOC_FAMILY needs no pinning here: upstream
# rk3588.inc already sets it to rk3588, which is the name rkbin deploys under.

SERIAL_CONSOLES ?= "1500000;ttyS2"

# When non-empty, kernel-yocto overwrites the SRC_URI defconfig with the in-tree one
KBUILD_DEFCONFIG = ""

UBOOT_ENTRYPOINT  = "0x02000000"
UBOOT_LOADADDRESS = "0x02000000"
