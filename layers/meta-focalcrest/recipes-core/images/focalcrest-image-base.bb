# SPDX-License-Identifier: MIT
# Copyright (c) 2026 Focalcrest

SUMMARY = "Focalcrest headless base image"

LICENSE = "MIT"

inherit core-image

require ${THISDIR}/focalcrest-image-common.inc

IMAGE_ROOTFS_EXTRA_SPACE = "65536"
