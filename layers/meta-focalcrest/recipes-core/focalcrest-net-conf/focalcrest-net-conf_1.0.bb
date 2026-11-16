# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "Focalcrest systemd-networkd configuration"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://20-wlan.network \
    file://30-ether.network \
"

S = "${UNPACKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	install -d ${D}${systemd_unitdir}/network
	install -m 0644 ${UNPACKDIR}/20-wlan.network ${D}${systemd_unitdir}/network/
	install -m 0644 ${UNPACKDIR}/30-ether.network ${D}${systemd_unitdir}/network/
}

FILES:${PN} = "${systemd_unitdir}/network"

RDEPENDS:${PN} = "systemd"
