# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "Grow the root partition and filesystem to fill the boot device"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://50-root.conf"

S = "${UNPACKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${nonarch_libdir}/repart.d
    install -m 0644 ${UNPACKDIR}/50-root.conf ${D}${nonarch_libdir}/repart.d/
}

# The systemd package installs systemd-repart.service/socket and their
# sysinit/sockets target wants; this recipe only supplies the partition rule.
FILES:${PN} = "${nonarch_libdir}/repart.d/50-root.conf"

RDEPENDS:${PN} = "systemd"
